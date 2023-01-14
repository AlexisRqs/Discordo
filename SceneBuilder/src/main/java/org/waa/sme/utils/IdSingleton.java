package org.waa.sme.utils;

public class IdSingleton {
    private static IdSingleton instance = null;
    private Long id;

    private IdSingleton() {
        id = 1L;
    }

    public static IdSingleton getInstance() {
        if (instance == null) {
            instance = new IdSingleton();
        }
        return instance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
