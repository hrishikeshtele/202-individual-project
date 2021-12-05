# 202-individual-project

## Introduction
This is a basic application that processes order and outputs success message into text file. If there are any error it
outputs into separate error.txt file.
This application gets csv file as command line argument to read order details. 

## Prerequisites

- [ ] Open JDK - [Openjdk 17](https://jdk.java.net/17/) is used as a JDK.

## Clone Project
- Project can be cloned from  [Github]( https://github.com/hrishikeshtele/202-individual-project).
- Make sure that you've sufficient rights / permissions to clone the project.

## Build Project
- Clone the code from Git into a folder, lets call this ***project_root***

- Run below commands from ***project_root*** directory for various tasks.

```bash
cd out\production\main
```
```bash
java com.ht.shop.ShopApplication "C:\Hrishi\202\project\inidividual\main\src\com\ht\shop\files\Dataset - Sheet1.csv" "C:\Hrishi\202\project\inidividual\main\src\com\ht\shop\files\Input1 - Sheet1.csv"
```
```bash
java com.ht.shop.ShopApplication "C:\Hrishi\202\project\inidividual\main\src\com\ht\shop\files\Dataset - Sheet1.csv" "C:\Hrishi\202\project\inidividual\main\src\com\ht\shop\files\Input2 - Sheet1.csv"
```
```bash
java com.ht.shop.ShopApplication "C:\Hrishi\202\project\inidividual\main\src\com\ht\shop\files\Dataset - Sheet1.csv" "C:\Hrishi\202\project\inidividual\main\src\com\ht\shop\files\Input3 - Sheet1.csv"
```