def build()  {
    node {
        // git url: '${giturlrepo}'
        // sh "${cmdname}"
        // sh "sudo docker build -t webdevprashant/javaapp:${BUILD_NUMBER} ."
        // sh "sudo docker run  -d -p 1222:8080 --name myjavaapp webdevprashant/javaapp:${BUILD_NUMBER}" 
        
        sh "echo 'Build'"
    }
}
    
def test(message)  {
    echo "INFO: ${message}"
}

def push()  {
    echo "INFO: Pushing"
}
