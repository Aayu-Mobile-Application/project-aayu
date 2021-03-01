package com.project.aayu.database;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class DynamoDataLoad {


    public static void loadData() throws IOException {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
            .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
            .build();

    DynamoDB dynamoDB = new DynamoDB(client);

    Table table = dynamoDB.getTable("Aayu");

    JsonParser parser = new JsonFactory().createParser(new File("plantData.json"));

    JsonNode rootNode = new ObjectMapper().readTree(parser);
    Iterator<JsonNode> iter = rootNode.iterator();
    ObjectNode currentNode;

        while (iter.hasNext()) {
            currentNode = (ObjectNode) iter.next();
            int ID = currentNode.path("ID").asInt();
            String Nomenclature = currentNode.path("Nomenclature").asText();


//            try {
//                table.putItem(new Item()
//                        .withPrimaryKey("ID", ID, "Nomenclature", Nomenclature)
//                        .withJSON("Stat", currentNode.path("Stat").toString()));
//                System.out.println("Successful load: " + ID + " " + Nomenclature);
//            } catch (Exception e) {
//                System.err.println("Cannot add product: " + ID + " " + Nomenclature);
//                System.err.println(e.getMessage());
//                break;
//            }
        }
        parser.close();

    }
}
