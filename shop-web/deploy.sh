cd shop-web-client
ng build --prod
cd ..
rm -r shop-web-server/web-application/src/main/resources/static
cp -r shop-web-client/dist shop-web-server/web-application/src/main/resources
mv shop-web-server/web-application/src/main/resources/dist shop-web-server/web-application/src/main/resources/static
cd shop-web-server
mvn clean package
rsync -avz /Users/anhdx/Desktop/On-boarding/startup.smart-market/shop-web/shop-web-server/web-application/target/dist startup@35.247.145.28:/home/startup/deploy/smart_market
cd ..
rm -r shop-web-mobile/sieuthimega/www
cp -r shop-web-client/dist shop-web-mobile/sieuthimega/www
