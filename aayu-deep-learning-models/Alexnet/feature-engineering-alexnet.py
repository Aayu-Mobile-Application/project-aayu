## Feature Engineering  for AlexNet

# Import Libriaries and Packages
import cv2
import os

# Create a function to read all the images in given folder
def loadImg(folderName) :
    images = []
    for filename in os.listdir(folderName) :
        image = cv2.imread(os.path.join(folderName,filename))
        if image is not None :
            images.append(image)
    return images

# Create a function to convert ( images to 256x256x3 )

def convertImg(folderName) :
    # Retrive data from folders
    folderPath = "./Dataset/Original-Dataset/"
    data = loadImg(folderPath+folderName)
    
    # Number of Images
    lenData = len(data)
    
    # Applying FOR loop to convert all images to the above size
    for i in range(len(data)) : 
        inputImg = data[i]
        width = int(inputImg.shape[1])
        height = int(inputImg.shape[0])
    
        borderType = cv2.BORDER_CONSTANT
        colorBorder = [255, 255, 255]
        increaseSize = 750

        if (height > width) :
            h = int((height-width)/2)
            hmax = int(h + increaseSize)
            output = cv2.copyMakeBorder(inputImg, increaseSize, increaseSize, hmax, hmax, borderType, None, colorBorder)
        else :
            w = int((width-height)/2)
            wmax = int(w + increaseSize)
            output = cv2.copyMakeBorder(inputImg, wmax, wmax, increaseSize, increaseSize, borderType, None, colorBorder)
        
        # Resize to Alexnet Image Size
        width = int(227)
        height = int(227)
    
        dsize = (width, height)
        outputImg = cv2.resize(output, dsize)
        
        folderPath = "./Dataset/Featured-Dataset/"
        imgName = ('/'+str(i+1)+'.jpg')
        filename = folderPath+folderName+imgName
        cv2.imwrite(filename, outputImg)
        
    print('Task Finished for '+folderName+' !')

# Apply for all folder

folderPath = "./Dataset/Original-Dataset/"
fileName = os.listdir(folderPath)

for i in range(len(fileName)) :
    convertImg(fileName[i])
    
print('Task Successfully Completed !')


