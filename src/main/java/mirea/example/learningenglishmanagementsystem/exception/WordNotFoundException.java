package mirea.example.learningenglishmanagementsystem.exception;

public class WordNotFoundException extends RuntimeException { // ToDo Добавить обработку ошибок
    public WordNotFoundException(String msg) {
        super(msg);
    }
}

