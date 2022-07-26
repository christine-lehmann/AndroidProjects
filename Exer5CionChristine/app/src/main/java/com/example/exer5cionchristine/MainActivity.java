package com.example.exer5cionchristine;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;
    EditText mTitleEt, mDescriptionEt;
    Button mSaveBtn, mListBtn, printBtn;
    ProgressDialog pd;
    FirebaseFirestore db;
    String pId, pTitle, pDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        printBtn = findViewById(R.id.printBtn);
        mTitleEt = findViewById(R.id.titleEt);
        actionBar = getSupportActionBar();
        mDescriptionEt = findViewById(R.id.descriptionEt);
        pd = new ProgressDialog(this);
        db = FirebaseFirestore.getInstance();
        mSaveBtn = findViewById(R.id.saveBtn);
        mListBtn = findViewById(R.id.listBtn);
        Bundle bundle = getIntent().getExtras();

        if(bundle != null) {
            actionBar.setTitle("Update File");
            mSaveBtn.setText("Update");
            pId = bundle.getString("pId");
            pTitle = bundle.getString("pTitle");
            pDescription = bundle.getString("pDescription");
            mTitleEt.setText(pTitle);
            mDescriptionEt.setText(pDescription);
        }else{
            actionBar.setTitle("Add File");
            mSaveBtn.setText("Save");
        }

        //mSaveBtn
        mSaveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (bundle != null) {
                    String id = pId;
                    String title = mTitleEt.getText().toString().trim();
                    String description = mDescriptionEt.getText().toString().trim();
                    updateData(id, title, description);
                }else {
                    String title = mTitleEt.getText().toString().trim();
                    String description = mDescriptionEt.getText().toString().trim();
                    uploadData(title, description);
                }
            }
        });

        //mListBtn
        mListBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, ListActivity.class));
                finish();
            }
        });

        //printBtn
        printBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = mTitleEt.getText().toString();
                String description = mDescriptionEt.getText().toString();
                try{
                    createdPdf(title, description);
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }
            }
        });

    }

    //updateData
    private void updateData(String id, String title, String description){
        pd.setTitle("Updating File...");
        pd.show();
        db.collection("Documents").document(id)
                .update("title", title, "search", title.toLowerCase(),"description", description)
                .addOnCompleteListener(new OnCompleteListener<Void>(){
                    @Override
                    public void onComplete(@NonNull Task<Void> task){
                        pd.dismiss();
                        Toast toast = Toast.makeText(MainActivity.this,"File Updated Successfully",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }).addOnFailureListener(new OnFailureListener(){
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast toast = Toast.makeText(MainActivity.this,"Error On Updating File", Toast.LENGTH_SHORT);
            }
        });
    }

    //createdPDF
    private void createdPdf(String title, String description) throws FileNotFoundException{
        String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new File(pdfPath,"myPDF.pdf");
        OutputStream outputStream = new FileOutputStream(file);

        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);

        pdfDocument.setDefaultPageSize(PageSize.A6);
        document.setMargins(0,0,0,0);


        Paragraph student = new Paragraph("Students").setBold().setFontSize(24).setTextAlignment(TextAlignment.CENTER);
        float[]width = {100f, 100f};
        Table table = new Table(width);
        table.setHorizontalAlignment(HorizontalAlignment.CENTER);

        table.addCell(new Cell().add(new Paragraph("Title")));
        table.addCell(new Cell().add(new Paragraph(title)));

        table.addCell(new Cell().add(new Paragraph("Description")));
        table.addCell(new Cell().add(new Paragraph(description)));

        document.add(student);
        document.add(table);
        document.close();

        Toast.makeText(MainActivity.this,"PDF Created", Toast.LENGTH_LONG).show();
    }


    //uploadData
    private void uploadData(String title, String description) {
        pd.setTitle("Adding File ...");
        pd.show();
        String id=UUID.randomUUID().toString();
        Map<String,Object> doc = new HashMap<>();
        doc.put("id",id);
        doc.put("title",title);
        //
        doc.put("search",title.toLowerCase());
        doc.put("description",description);
        db.collection("Documents").document(id).set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        pd.dismiss();
                        Toast toast = Toast.makeText(MainActivity.this, "File Added Successfully", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }).addOnFailureListener(new OnFailureListener(){
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast toast = Toast.makeText(MainActivity.this, "Error On Adding File", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}

