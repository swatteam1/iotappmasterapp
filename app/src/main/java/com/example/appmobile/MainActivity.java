package com.example.appmobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.rengwuxian.materialedittext.MaterialEditText;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnRegister; // Кнопки отображения окон авторизации и регистрации

    // Relative данного activity
    RelativeLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализируем кнопки отображения окон авторизации и регистрации
        btnSignIn = findViewById(R.id.btnSignIn);
        btnRegister = findViewById(R.id.btnRegister);

        // Инициализируем Relative
        root = findViewById(R.id.root_element);

        // Устанавливаем обработчик событий для кнопки отображения окна регистрации
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterWindow(); // Метод для кнопки отображения окна регистрации
            }
        });
        // Устанавливаем обработчик событий для кнопки отображения окна авторизации
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignInWindow(); // Метод для кнопки отображения окна авторизации
            }
        });
    }

    private void showRegisterWindow() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this); // Создаем всплывающее окно, которое будет отображаться в этом activity
        dialog.setTitle("Зарегистрироваться"); // Устанавливаем заголовок
        dialog.setMessage("Введите все данные для регистрации"); // Добавляем сообщение для пользователя

        // Получаем созданный шаблон для регистрации
        LayoutInflater inflater = LayoutInflater.from(this);
        View register_window = inflater.inflate(R.layout.register_window, null);
        // Устанавливаем шаблон
        dialog.setView(register_window);

        // Получаем данные с полей
        final MaterialEditText email = register_window.findViewById(R.id.emailField);
        final MaterialEditText name = register_window.findViewById(R.id.nameField);
        final MaterialEditText pass = register_window.findViewById(R.id.passField);
        final MaterialEditText phone = register_window.findViewById(R.id.phoneField);

        // Кнопка отмены
        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss(); // Скрытие окна регистрации
            }
        });

        // Кнопка добавить
        dialog.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if(TextUtils.isEmpty(email.getText().toString())) {
                    Snackbar.make(root, "Введите вашу почту", Snackbar.LENGTH_SHORT).show(); // Сообщение об ошибке пустого поля email
                    return;
                }

                if(TextUtils.isEmpty(name.getText().toString())) {
                    Snackbar.make(root, "Введите ваше имя", Snackbar.LENGTH_SHORT).show(); // Сообщение об ошибке пустого поля name
                    return;
                }

                if(pass.getText().toString().length() < 5) {
                    Snackbar.make(root, "Введите пароль, который 5 и более символов", Snackbar.LENGTH_SHORT).show(); // Сообщение об ошибке меньшей длины символов для пароля
                    return;
                }

                if(TextUtils.isEmpty(phone.getText().toString())) {
                    Snackbar.make(root, "Введите ваш телефон", Snackbar.LENGTH_SHORT).show(); // Сообщение об ошибке пустого поля phone
                    return;
                }

                // Регистрация пользователя

            }
        });

        dialog.show();
    }

    private void showSignInWindow(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this); // Создаем всплывающее окно, которое будет отображаться в этом activity
        dialog.setTitle("Войти"); // Устанавливаем заголовок
        dialog.setMessage("Введите данные для входа"); // Добавляем сообщение для пользователя

        // Получаем созданный шаблон для авторизации
        LayoutInflater inflater = LayoutInflater.from(this);
        View sign_in_window = inflater.inflate(R.layout.sign_in_window, null);
        // Устанавливаем шаблон
        dialog.setView(sign_in_window);

        // Получаем данные с полей
        final MaterialEditText email = sign_in_window.findViewById(R.id.emailField);
        final MaterialEditText pass = sign_in_window.findViewById(R.id.passField);

        // Кнопка отмены
        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss(); // Скрытие окна авторизации
            }
        });

        // Кнопка добавить
        dialog.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if(TextUtils.isEmpty(email.getText().toString())) {
                    Snackbar.make(root, "Введите вашу почту", Snackbar.LENGTH_SHORT).show(); // Сообщение об ошибке пустого поля email
                    return;
                }

                if(pass.getText().toString().length() < 5) {
                    Snackbar.make(root, "Введите пароль, который 5 и более символов", Snackbar.LENGTH_SHORT).show(); // Сообщение об ошибке меньшей длины символов для пароля
                    return;
                }

                // Авторизация пользователя

            }
        });

        dialog.show();
    }
}
