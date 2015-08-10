package com.htcursos.sprinklesapp;

import android.app.Application;

import com.htcursos.sprinklesapp.migrations.CreateUserMigration;

import se.emilsjolander.sprinkles.Sprinkles;

/**
 * Created by Virmerson on 31/07/15.
 * Ao Rodar pela primeira Vez o APP
 * https://github.com/emilsjolander/sprinkles
 */
public class SprinklesAppApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        //Carregando o Sprinkles
        Sprinkles sprinkles =  Sprinkles.init(getApplicationContext());
        //Criando o banco
        runMigrations(sprinkles);
    }

    /**
     * AS classes que irão criar o banco
     */
    private  void runMigrations (Sprinkles sprinkles){
        //Para cada tabela um Migration
        sprinkles.addMigration(new CreateUserMigration());

        //Adicionar mais migrations aqui
    }
}