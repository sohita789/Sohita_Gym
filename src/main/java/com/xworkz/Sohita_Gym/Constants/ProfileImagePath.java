package com.xworkz.Sohita_Gym.Constants;

import lombok.Getter;

@Getter
public enum ProfileImagePath {
    ProfileImagePath("C:\\img\\");

    private String path;

    ProfileImagePath(String path){
        System.out.println("path in ProfileImagePath");
        this.path=path;
    }
}
