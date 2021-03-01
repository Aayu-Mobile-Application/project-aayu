# Integration Keras Deep Learning Models With Spring

## Model Training

The first step is to train a model using the Keras library in Python. Once you have a model that is ready to deploy, you can save it in the h5 format and utilize it in Python and Java applications.For this tutorial, we’ll use the same model that I trained for predicting which players are likely to purchase a new game in my blog post on Flask.

    import keras
    from keras import models, layers# Define the model structure
    model = models.Sequential()
    model.add(layers.Dense(64, activation='relu',
    input_shape=(10,)))
    model.add(layers.Dense(1, activation='sigmoid'))# Compile and fit the model
    model.compile(optimizer='rmsprop',loss='binary_crossentropy',
              metrics=[auc])
              history = model.fit(x, y, epochs=100, batch_size=100,
                    validation_split = .2, verbose=0)# Save the model in h5 format 
                    model.save("games.h5")
## Java Setup

To deploy Keras models with Java, we’ll use the Deeplearing4j library. It provides functionality for deep learning in Java and can load and utilize models trained with Keras. We’ll also use Dataflow for batch predictions and Jetty for real-time predictions. Here’s the libraries I used for this project:

-   [**Deeplearning4j**](https://deeplearning4j.org/)**:** Provides deep neural network functionality for Java.
-   [**ND4J**](https://nd4j.org/)**:** Provides tensor operations for Java.
-   [**Jetty**](https://www.eclipse.org/jetty/)**:** Used for setting up a web endpoint.
-   [**Cloud DataFlow:**](https://cloud.google.com/dataflow/) Provides autoscaling for batch predictions on GCP.

  ## Conclusion

As deep learning becomes increasingly popular, more languages and environments are supporting these models. As libraries start to standardize on model formats, it’s becoming possible to use separate languages for model training and model deployment. This post showed how neural networks trained using the Keras library in Python can be used for batch and real-time predictions using the DL4J library in Java. For the first time, I’ve been able to set up a batch process for applying deep learning to millions of data points.

