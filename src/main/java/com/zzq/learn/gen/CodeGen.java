package com.zzq.learn.gen;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.zzq.learn.model.entity.base.BaseEntity;
import com.zzq.learn.model.result.R;

public class CodeGen {
    static String dbUrl = "jdbc:mysql://127.0.0.1/test";
    static String dbUserName = "root";
    static String dbPassword = "123456";

    public static void main(String[] args) {

        DataSourceConfig dataSourceConfig = new DataSourceConfig
                .Builder(dbUrl, dbUserName, dbPassword)
                .build();

        GlobalConfig globalConfig = new GlobalConfig
                .Builder()
                .outputDir(System.getProperty("user.dir") + "\\src\\main\\java")
                .openDir(false)
//                .fileOverride()
                .author("ZZQ")
                .build();

        PackageConfig packageConfig = new PackageConfig
                .Builder()
                .parent("com.zzq.learn")
                .entity("model.entity")
                .xml("mapper.xml")
                .build();

        StrategyConfig strategyConfig = new StrategyConfig
                .Builder()
                .entityBuilder()
                    .superClass(BaseEntity.class)
                    .enableLombok()
                    .naming(NamingStrategy.underline_to_camel)
                    .addTableFills(new Column("create_time", FieldFill.INSERT))
                    .addTableFills(new Column("update_time", FieldFill.INSERT_UPDATE))
                .controllerBuilder()
                    .superClass(R.class)
                    .enableRestStyle()
                .build();


        AutoGenerator autoGenerator = new AutoGenerator(dataSourceConfig);
        autoGenerator.global(globalConfig);
        autoGenerator.packageInfo(packageConfig);
        autoGenerator.strategy(strategyConfig);
        autoGenerator.execute(new FreemarkerTemplateEngine());
    }
}
