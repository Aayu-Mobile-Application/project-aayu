## Data Augmentation for AlexNet

# Import Libraries and Packages
import os
import cv2

# For Data Augmentation using Keras
from keras.preprocessing.image import ImageDataGenerator, array_to_img, img_to_array, load_img

# For Implemenation of the model
from keras.models import Sequential
from keras.layers import Conv2D, MaxPooling2D
from keras.layers import Activation, Dropout, Flatten, Dense

# Create a function to read all the images in given folder
def loadImg(folderName) :
    images = []
    for filename in os.listdir(folderName) :
        image = cv2.imread(os.path.join(folderName,filename))
        if image is not None :
            images.append(image)
    return images

listOfFolders = os.listdir('./Dataset')
print(listOfFolders)

listOfSubFolders = os.listdir('./Dataset/Featured-Dataset/')
print(listOfSubFolders)

imgFolderName = './Dataset/Data-Augmentation/'+listOfSubFolders[1]
print(imgFolderName)


datagen = ImageDataGenerator(
    rotation_range = 25,
    width_shift_range = 0.1,
    height_shift_range = 0.1,
    shear_range = 0.1,
    zoom_range = 0.1,
    horizontal_flip = True,
    vertical_flip = True,
    fill_mode = 'nearest' )

for i in range(len(listOfSubFolders)) :
    imgFolderName = './Dataset/Featured-Dataset/'+listOfSubFolders[i]+'/'
    print('Source Folder : ',imgFolderName)
    saveFolder = './Dataset/Data-Augmentation/'+listOfSubFolders[i]
    print('Output Folder : ',saveFolder)
    
    listOfImages = loadImg(imgFolderName)
    
    for x in range(len(listOfImages)) :
        imgName = str(i+1)+'.jpg'
        imgPath = imgFolderName+imgName
    
        image = load_img(imgPath)
        x = img_to_array(image)
        x = x.reshape((1,) + x.shape)
        
        j = 0
        for batch in datagen.flow(x, batch_size = 1, save_to_dir=saveFolder, save_prefix='aayu', save_format='jpg' ) :
            j += 1
            if j > 10:
                break
                
    print('Task Completed !\n')

# Calculate Number of Images
numOriginalImg = 0
numAugmentedImg = 0
for z in range(len(listOfSubFolders)) :
    originalFolders = os.listdir('./Dataset/Featured-Dataset/'+listOfSubFolders[z])
    numOriginalImg = numOriginalImg + int(len(originalFolders))
    
    augmentFolders = os.listdir('./Dataset/Data-Augmentation/'+listOfSubFolders[z])
    numAugmentedImg = numAugmentedImg + int(len(augmentFolders))

print('Number of Image before applying augmentation : ',numOriginalImg)
print('Number of Image after applying augmentation : ',numAugmentedImg)

### Rename Image with specific format --> number.jpg


for y in range(len(listOfSubFolders)) :
    
    filepath = './Dataset/Data-Augmentation/'+listOfSubFolders[y]+'/'
    allImgName = os.listdir(filepath)
    
    for z in range(len(allImgName)) :
        imgOldName = filepath+allImgName[z]
        imgNewName = filepath+str(z+1)+'.jpg'
        os.rename(imgOldName,imgNewName)

print('Task Completed !')

import keras, os, cv2
import pandas as pd
import numpy as np

path = './Dataset/Data-Augmentation/'
dataset = os.listdir(path)

labels=[i for i in range(len(dataset))]
print(labels)
label_dict=dict(zip(dataset,labels))
print(label_dict)

# Create two empty list for images and targets
images=[]
target=[]

# Resize and append Images to the Image list and append label to the Label list
for data in dataset :
  folderPath = os.path.join(path,data)
  imgNames = os.listdir(folderPath)
    
  for imgName in imgNames:
    imgPath = os.path.join(folderPath, imgName)
    img = cv2.imread(imgPath)
    images.append(img)
    target.append(label_dict[data])

from keras.utils import np_utils

images = np.array(images)
target = np.array(target)
new_target=np_utils.to_categorical(target)

np.save('images',images)
np.save('target',new_target)

# Count Number of Images
countImg = 0

for i in range(len(dataset)) :
    folder = path+'/'+dataset[i]
    imgName = os.listdir(folder)
    countImg = countImg + len(imgName)
