# parking_lot

### Description ###

parking_lot is an application to manage a parking lot for cars.

### How to run ###
First, run the setup script from project root. This script will fetch needed dependencies and run JUnit.
```
$ bin/setup
```
To run the app, there are two ways:
1. Interactive mode. Run the following script without any argument, and provide the input via command line. Type exit to end program.
    ```
    $ bin/parking_lot
    $ create_parking_lot 6
    Created a parking lot with 6 slots
    $ park KA-01-HH-1234 White
    Allocated slot number: 1
    $ exit
    ```
2. File-based mode. In this one, the input is already defined in a text file. One just needs to pass one argument containing the file name. The program will read the line one by one and return the corresponding output. 
    ```
    $ bin/parking_lot file_inputs.txt
    Created a parking lot with 6 slots
    Allocated slot number: 1
    ```
    
### Supported Commands ###
```
create_parking_lot <size of parking lot>
park <registration plate> <car colour>
leave <slot number>
status
registration_numbers_for_cars_with_colour <colour>
slot_numbers_for_cars_with_colour <colour>
slot_number_for_registration_number <registration plate>
```