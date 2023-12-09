package com.example.mlseriesdemonstrator;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class CameraActivity extends AppCompatActivity {
    private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        // Verificar si se tiene el permiso de la cámara
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // Si no se tiene el permiso, solicitarlo al usuario
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION_REQUEST_CODE);
        } else {
            // Si se tiene el permiso, realizar las operaciones necesarias para el reconocimiento facial o la funcionalidad de la cámara
            // Aquí puedes implementar tu lógica para la cámara y el reconocimiento facial
            Toast.makeText(this, "Camera permission granted", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso de la cámara concedido, realizar las operaciones necesarias para el reconocimiento facial o la funcionalidad de la cámara
                // Aquí puedes implementar tu lógica para la cámara y el reconocimiento facial
                Toast.makeText(this, "Camera permission granted", Toast.LENGTH_SHORT).show();
            } else {
                // Permiso de la cámara denegado, mostrar un mensaje o tomar alguna acción correspondiente
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void startCamera() {
        // Aquí puedes implementar tu lógica para la cámara y el reconocimiento facial
        // Por ejemplo, puedes inicializar la cámara y configurar los callbacks para el reconocimiento facial
        // También puedes mostrar la vista previa de la cámara en un SurfaceView o TextureView
    }
}
