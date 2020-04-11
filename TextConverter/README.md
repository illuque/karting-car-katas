# HtmlTextConverter.java 

## What are the problems with this class?
- **HtmlTextConverter** is loading a file and parsing every line to convert it to html. Pay attention to the _AND_... This class is clearly doing more than one thing!
    - Loading the file in a _BufferedReader_
    - Parsing every line to convert it to valid html
- If we want to change the reader type, a faster one i.e., we will have to modify this class
- If we want to read from a different source instead of a file, i.e. EFS, we will have to modify this class
    
## My changes
- Created **FileLoaderImpl**, in charge loading and reading lines from the file
- Created **FileLoader** interface, so **HtmlTextConverter** depends upon an abstraction
- Now **HtmlTextConverter** class does just one thing: parsing the giving file by reading each line
    - Of course we could have gone further so this class receives a _String_, but we know this is not the best approach to read big files

## What principle does this class violate? Why?

### SRP
- It is clearly doing more than one thing
- It has more than one reasons to change:
    - changing the reader type
    - changing the way to convert the html

### DIP
- It is instantiating the file reading dependencies (_new BufferedReader(new FileReader(xxx))_)
- Alarm class would have to change if we change the source of the file