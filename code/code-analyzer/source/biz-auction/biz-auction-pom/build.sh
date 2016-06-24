#/user/bin

echo " ---------------------------0 set source path  -----------------------------"
AUC_Path=$(cd `dirname $0`; pwd)
Release_Path=/build/release
Mvn_Repos=/root/.m2/repository/com/autostreets

echo " -------------------1 update build source & release package  ---------------------"
svn update ${AUC_Path}/..

#svn cleanup $Release_Path
svn update $Release_Path

echo -n "Press any key to continue...:"
read  any

#<<block
echo " --------------------------- 2 clean m2 repository   -----------------------------"
rm -rf $Mvn_Repos/biz/autostreets-api/*
rm -rf $Mvn_Repos/biz/biz-auth-api/*
rm -rf $Mvn_Repos/biz/biz-bi-api/*
rm -rf $Mvn_Repos/biz/biz-cas-api/*
rm -rf $Mvn_Repos/biz/biz-cms-api/*
rm -rf $Mvn_Repos/biz/biz-common-api/*
rm -rf $Mvn_Repos/biz/biz-payment-api/*
rm -rf $Mvn_Repos/biz/biz-sms-api/*
rm -rf $Mvn_Repos/biz/biz-sys-api/*
rm -rf $Mvn_Repos/biz/biz-usedvehicle-api/*
rm -rf $Mvn_Repos/biz/biz-workflow-api/*
rm -rf $Mvn_Repos/biz/biz-wtms-api/*
#block
rm -rf $Mvn_Repos/biz/biz-auction-api/*
#block

echo " --------------------------- 3 deploy biz-auction api -----------------------------"
cd $AUC_Path/../biz-auction-api
mvn clean deploy
echo -n "Press any key to continue...:"
read  any

#block
echo " --------------------------- 4.1 deploy biz-auction-pom  stage-----------------------------"

cd $AUC_Path
mvn clean package -P stage
echo -n "build successful------------Press any key to continue...:"
read  any

echo " ----------------------------------- 4.2 cp auction war stage-------------------------------------"
cp $AUC_Path/../biz-auction-service/target/autostreets-auctionservice-assembly.tar.gz $Release_Path/stage/
cp $AUC_Path/../biz-auction-admin/target/admin-auction.war $Release_Path/stage/
cp $AUC_Path/../biz-auction-web/target/auction.war $Release_Path/stage/

echo " --------------------------- 5.1 deploy biz-auction-pom  prod-----------------------------"
cd $AUC_Path
mvn clean package -P prod
echo -n "stage build successful------------Press any key to continue to build prod...:"
read  any

echo " -----------------------------------5.2 cp auction war prod -------------------------------------"
cp $AUC_Path/../biz-auction-service/target/autostreets-auctionservice-assembly.tar.gz $Release_Path/prod/
cp $AUC_Path/../biz-auction-admin/target/admin-auction.war $Release_Path/prod/
cp $AUC_Path/../biz-auction-web/target/auction.war $Release_Path/prod/

echo -n "--------------------copy over,Press any key to continue to commit in:"
read  any

echo " ----------------------------------- ci -------------------------------------"
svn ci $Release_Path -m "auction commit in"

echo " --------------------------------------------------------------------------------"
echo " ----------------------   "build successful !!" ---------------------------------"

echo " --------------------------------------------------------------------------------"
