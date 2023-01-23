# IMAXT StarDist Cellpose

This repository includes StarDist [1,2] and Cellpose [3] nuclei segmentation models trained using all publicly available and IMAXT data. It also includes notebooks for running the inference using these models. For the instalation of StarDist and Cellpose please refer to the following links:<br />
StarDist: [https://github.com/stardist/stardist](https://github.com/stardist/stardist)<br />
Cellpose: [https://github.com/MouseLand/cellpose](https://github.com/MouseLand/cellpose)

In order to train new Cellpose and StarDist models we generated a new dataset of the imaging modalities used in the IMAXT project. Images were acquired from 18 tissue samples of various healthy organs and tumor types of mouse models. From 13 of these samples, images had been acquired using the ZEISS Axioscan, while the remaining 5 samples had been imaged using MERFISH. Representative image regions were manually selected to generate a dataset that captures the wide range of variation in appearance of various tissue and cell types, including the particular challenging cases. The MERFISH images were furthermore down-sampled to accommodate the receptive field of StarDist.

For the manual segmentation of the cell nuclei we recruited 8 volunteers. Each of these annotators was subsequently assigned one image from each of the 18 tissue samples, which have on average 305 cells per image. The annotations were performed using [QuPath](https://qupath.github.io/) v0.3.x. Using this software, the annotator was able to have the annotations of the cells overlap. These were converted to images with non overlapping cells by generating a distance map for each cell mask, and assigning pixels to a cell only when they have the a larger value in the distance map compared to the other cells. The resulting manually annotated dataset of 144 images was were split randomly into 128 for training and 16 for testing, while making sure the test set includes all modalities and tissue types.

For the training of the model we additionally added publicly available datasets of fluorescent images with annotated cell nuclei to further enhance the generalizability of the model. These public datasets include BBBC020, BBBC038v1 and BBBC039v1 from the Broad Bioimage Benchmark Collection [4,5,6]. For BBBC038v1 we used the fluorescent images of "stage1_train" only, from the unofficial fixes by Konstantin Lopuhin (https://github.com/lopuhin/kaggle-dsbowl-2018-dataset-fixes). We also used the images from Coelho et al. [7], which consists of hand-segmented nuclear images of 3T3 and U20S cells.

**These models are for non-commercial use only.**

The pretrained models by StarDist and Cellpose together with our new models were tested on the 16 images from the IMAXT test set, which produced the following results:
|Method   |Model   |Pixel-wise F1   |Object-wise F1   |
|---|---|---|---|
|Cellpose |nuclei<br>IMAXT_Cellpose   |0.68±0.24<br>0.86±0.04   |0.59±0.28<br>0.79±0.12   |
|StarDist |2D_paper_dsb2018<br>2D_versatile_fluo<br>IMAXT_StarDist |0.73±0.17<br>0.80±0.06<br>0.85±0.03 |0.51±0.29<br>0.59±0.22<br>0.76±0.08|


# References


1. Uwe Schmidt, Martin Weigert, Coleman Broaddus, and Gene Myers.
    Cell Detection with Star-convex Polygons.
    International Conference on Medical Image Computing and Computer-Assisted Intervention (MICCAI), Granada, Spain, September 2018.
2. Martin Weigert, Uwe Schmidt, Robert Haase, Ko Sugawara, and Gene Myers.
    Star-convex Polyhedra for 3D Object Detection and Segmentation in Microscopy.
    The IEEE Winter Conference on Applications of Computer Vision (WACV), Snowmass Village, Colorado, March 2020
3. Stringer, C., Wang, T., Michaelos, M., & Pachitariu, M. (2021). Cellpose: a generalist algorithm for cellular segmentation. Nature methods, 18(1), 100-106.
4. Vebjorn Ljosa, Katherine L Sokolnicki, and Anne E Carpenter. “Annotated high-throughput microscopy image sets for903
validation”. In: Nature Methods 9.7 (2012), pp. 637–637. DOI: 10.1038/nmeth.2083.904
5. Juan C. Caicedo et al. “Nucleus segmentation across imaging experiments: The 2018 Data Science Bowl”. In: Nature905
Methods 16.12 (2019), pp. 1247–1253. DOI: 10.1038/s41592-019-0612-7.906
6. Juan C. Caicedo et al. “Evaluation of deep learning strategies for nucleus segmentation in fluorescence images”. In:907
Cytometry Part A 95.9 (2019), pp. 952–965. DOI: 10.1002/cyto.a.23863.908
7. Luis Pedro Coelho, Aabid Shariff, and Robert F. Murphy. “Nuclear segmentation in microscope cell images: A hand-909
segmented dataset and comparison of algorithms”. In: 2009 IEEE International Symposium on Biomedical Imaging:910
From Nano to Macro. 2009, pp. 518–521. DOI: 10.1109/ISBI.2009.5193098
