import qupath.ext.stardist.StarDist2D

// Specify the model file (you will need to change this!)
def pathModel = 'model.pb' //Add path of model file

def stardist = StarDist2D.builder(pathModel)
        .threshold(0.5)              // Probability (detection) threshold
        .channels(0)                 // Specify detection channel
        .normalizePercentiles(1, 99) // Percentile normalization
        .build()

// Run detection for the selected objects
def imageData = getCurrentImageData()
def pathObjects = getSelectedObjects()
if (pathObjects.isEmpty()) {
    Dialogs.showErrorMessage("StarDist", "Please select a parent object!")
    return
}

stardist.detectObjects(imageData, pathObjects)

println 'Done!'