# commonWordsFromFiles

To run application(target package is war and server is tomcat)  : 
git clone https://github.com/jb4515/commonWordsFromFiles.git
cd commonWordsFromFiles
mvn clean package

mv target/common-words-from-files-1.0.war {tomcat_path}/webapps
cd /{tomcat_path}/bin
.startup.sh

Use postman for POST request to http://localhost:8080/common-words-from-files-1.0/api/v1/commonwords with request body as list if string filenames
Request Body sample  -> ["file1.txt", "file2.txt", "file3.txt"]
