package com.zzq.learn.gen;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.zzq.learn.model.entity.base.BaseEntity;
import com.zzq.learn.model.result.R;

import java.util.Collections;
import java.util.Scanner;

public class CodeGen {
    static String dbUrl = "jdbc:mysql://127.0.0.1/test";
    static String dbUserName = "root";
    static String dbPassword = "123456";
    static String root = System.getProperty("user.dir");
    static String javaDir = root + "\\src\\main\\java";
    static String resourcesDir = root + "\\src\\main\\resources";

    public static void main(String[] args) {
        System.out.print("all\t\t\t\t所有表\ntable1,table2\t指定表\n输入表名：");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        if ("all".equals(input)) {
            exec();
        } else {
            String[] tables = input.split(",");
            exec(tables);
        }
    }

    public static void exec(String ...include) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig
                .Builder(dbUrl, dbUserName, dbPassword)
                .build();

        GlobalConfig globalConfig = new GlobalConfig
                .Builder()
                .outputDir(javaDir)
                .disableOpenDir()
//                .fileOverride()
                .author("ZZQ")
                .build();

        PackageConfig packageConfig = new PackageConfig
                .Builder()
                .parent("com.zzq.learn")
                .pathInfo(Collections.singletonMap(OutputFile.mapperXml, resourcesDir + "\\mapper"))
                .entity("model.entity")
                .build();

        StrategyConfig strategyConfig = new StrategyConfig
                .Builder()
                .addInclude(include)
                .entityBuilder()
                    .superClass(BaseEntity.class)
                    .enableLombok()
                    .idType(IdType.AUTO)
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
