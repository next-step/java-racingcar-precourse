version 1.0
# java-racingcar-precourse 
### interface Observer
* update() : void
---
### interface Subject
* addObserver(Observer) : void
* removeObserver(Observer) : void
* notifyObservers() : void
---
### interface CarModelInterface
* getName() : String
* getProgress() : int
* setProgress() : void
---
### interface RaceModelInterface
* getNumberOfCars() : int
* getNumberOfRounds() : int
* setNumberOfRounds() : void
* getCars() : List<CarServiceInterface>
---
### interface CarServiceInterface
* move() : void
---
### interface RaceServiceInterface
* getNumberOfCars() : int
* getNumberOfRounds() : int
* setNumberOfRounds() : void
---
### interface RaceViewInterface
* userCarsInput() : void
* userRoundsInput() : void
* printProgress() : void
* printProcess() : void
* printResult() : void
---
### interface RaceControllerInterface
* init() : void
* play() : void
* end() : void
* addCar(CarServiceInterface) : void
* setRound(int) : void
---
### class CarServiceTest
---
### class RaceServiceTest
---
### class Car - model
* name : String
* progress : int
* getName() : String
* getProgress() : int
* setProgress() : void
---
### class Race : Subject, RaceServiceInterface - model
* numberOfCars : int
* numberOfRounds : int
* cars : List<CarServiceInterface>
* observers : List<Observer>
* getNumberOfCars() : int
* getNumberOfRounds() : int
* setNumberOfRounds() : void
* getCars() : List<CarServiceInterface>
* addObserver(Observer) : void
* removeObserver(Observer) : void
* notifyObservers() : void
---
### CarService : CarServiceInterface - service
* car : CarModelInterface
* goForward() : void
* move() : void
* nameValidation() : boolean
---
### RaceService : RaceServiceInterface - service
* race : RaceModelInterface
* addCar(CarServiceInterface) : void
* setRound(int) : void
* roundValidation() : boolean
* addObserver(Observer) : void
* removeObserver(Observer) : void
* notifyObservers() : void
---
### class RaceView : Observer, RaceViewInterface - view
* raceServiceInterface : RaceServiceInterface
* raceControllerInterface : RaceControllerInterface
* userCarsInput() : void
* userRoundsInput() : void
* printProgress() : void
* printProcess() : void
* printResult() : void
---
### RaceController : RaceControllerInterface - controller
* race : RaceServiceInterface
* view : RaceViewInterface
* init() : void
* addCar(CarServiceInterface) : void
* setRound(int) : void
* play() : void
* end() : void
