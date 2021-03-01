package com.project.aayu.controller;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.io.ClassPathResource;

import java.io.IOException;


public class DeepLearningModels {

    // load the model
    String simpleMlp;

    {
        try {
            simpleMlp = new ClassPathResource("model.h5").getFile().getPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    MultiLayerNetwork model;

    {
        try {
            model = KerasModelImport.importKerasSequentialModelAndWeights(simpleMlp);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidKerasConfigurationException e) {
            e.printStackTrace();
        } catch (UnsupportedKerasConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void inputDesign(){

    }

    public int predictionResult(){
        //int prediction = model.output(features).getDouble(0);
        return 0;
    }

}
