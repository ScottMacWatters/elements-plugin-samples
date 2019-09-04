import com.example.elements.HelloWorld

atom('hello_world') {
    configuration = """
    _hw:
        waitTime: ^10 * SECOND
        message: This is configured via groovy
"""
    _hw = HelloWorld
}