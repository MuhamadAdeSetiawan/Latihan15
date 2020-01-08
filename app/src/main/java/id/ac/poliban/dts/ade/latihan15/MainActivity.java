package id.ac.poliban.dts.ade.latihan15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    EditText etFileName;
    private Button btCreateFile;
    private Button btDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
    }

    private void initComponent() {
        etFileName = findViewById(R.id.etFileName);
        btCreateFile = findViewById(R.id.btCreate);
        btDelete = findViewById(R.id.btDelete);

        btCreateFile.setOnClickListener(v -> {
            File file = new File(getFilesDir(), etFileName.getText().toString());
            try {
                file.createNewFile();

                Toast.makeText(this, "File Telah Dibuat", Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btDelete.setOnClickListener(v -> {
            File file = new File(getFilesDir(), etFileName.getText().toString().trim());
            file.delete();
            Toast.makeText(this, etFileName.getText().toString() + "Sudah dihapus", Toast.LENGTH_SHORT).show();
        });

        btShowFiles.setOnClickListener(v ->{
            File file = new File(getFilesDir(), ".");
            String[]