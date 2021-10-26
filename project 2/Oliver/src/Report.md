<hdr>Report for assignment 3<hdr>

For the class MovingPoint the fields has been initialized as private to ensure proper encapsulation. 

For the direction and assignments to it in general modulo has been utilized to ensure that the variable stays within the range [0-360]. We also at the constructor and the instance method turnBy ensures that non-positive directions/angles will be "translated" to their equal angle within the range. 
Likewise for the speed variable, we both in the constructor and the accelerateBy instance method ensure that the speed can't exceed the given range [0-20]. 

For moving the object (point) in the instance method move basic trigonomic functions for right-angled triangles is utilized to calculate the translation of the x- and y-coordinates.  This has been implemented in Java through the "Math" library, where the direction has been translated to radians as well. In the method move the parameter duration is given as a long datatype. 
In order to ensure we move the correct "duration" a for loop is exercised, where we for each unit of duration move the given speed and direction. This is only done a full integer of times in a for loop, thus the duration has been rounded down. After this, the (possible) remainder of duration, found by modulo 1, is used to find the last part of the move.  