package me.shadowchild.modmanager;

import java.io.File;

public class GenericConfig implements ConfigHandler.IConfig {

    @Override
    public String getName() {

        return "Generic";
    }

    @Override
    public void loadConfig(File configFolder) {

    }
}