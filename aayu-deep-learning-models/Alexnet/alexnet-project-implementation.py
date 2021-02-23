# load and evaluate a saved model
from numpy import loadtxt
from keras.models import load_model
 
# load model
model = load_model('alexnet-model.h5')

# pre-procesing image before prediction - part 1
import os, cv2

def process_img(inputImg):
    
    # Border type, colour and increasing size
    borderType = cv2.BORDER_CONSTANT
    colorBorder = [255, 255, 255]
    increaseSize = 500
    
    # Getting Image Resolution
    widthImg = inputImg.shape[1]
    heightImg = inputImg.shape[0]
        
    # Increase border size and center image
    if (widthImg > heightImg):
        r = widthImg-heightImg
        rmax = r+increaseSize
        inputImg = cv2.copyMakeBorder(
            inputImg, rmax, rmax, increaseSize,
            increaseSize, borderType, None, colorBorder)
    else:
        r = heightImg-widthImg
        rmax = r+increaseSize
        inputImg = cv2.copyMakeBorder(
            inputImg, increaseSize, increaseSize,
            rmax, rmax, borderType, None, colorBorder)
        
    # Resize Image into 227 x 227
    imgSize = 227,227
    inputImg = cv2.resize(inputImg, imgSize)
    
    filename = 'output.jpg'
    cv2.imwrite(filename, inputImg)

# pre-procesing image before prediction - part 2
import numpy as np

def img_process(inputImg):
    image = []
    image.append(inputImg)
    outputImg = np.array(image)
    return outputImg

# Testing Function
inputImg1 = cv2.imread('./sample.jpg')
inputImg2 = cv2.imread('./output.jpg')
process_img(inputImg1)
im = img_process(inputImg2)

# Read Image and Preview
img = cv2.imread("./output.jpg")
cv2.imshow("Resized image", img)
cv2.waitKey(0)
cv2.destroyAllWindows()

outputLabel = model.predict(im)
outputList = outputLabel[0].tolist()
maxValue = max(outputList)
place = outputList.index(maxValue)

if (maxValue > 0.5):
    if (place == 0):
        print('Arjun')
    elif (place == 1):
        print('Basil')
    elif (place == 2):
        print('Chinar')
    elif (place == 3):
        print('Guava')
    elif (place == 4):
        print('Jamun')
    elif (place == 5):
        print('Jatropa')
    elif (place == 6):
        print('Lemon')
    elif (place == 7):
        print('Mango')
else:
    print('Not Found !')

