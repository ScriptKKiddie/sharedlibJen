def build(message)  {
    node {
        echo "INFO: ${message}"
    }
}
    
def test(message)  {
    echo "INFO: ${message}"
}

def push()  {
    echo "INFO: Pushing"
}
