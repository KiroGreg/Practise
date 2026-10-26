class Car:
    color = "green"

    def __init__(self, brand, model, fuel, speed):
        self.brand = brand
        self.model = model
        self.fuel = fuel
        self.move = False
        self.speed = speed

    def start(self):
        self.move = True
        print("Car was turned on")

    def __repr__(self):
        return self.color

    def halt(self):
        pass

    def drift(self):
        pass

    def speedup(self):
        if self.move is True:
            self.speed += 10
            print("speed = ", self.speed)
        else:
            print("not evaluable")

    def turn(self):
        pass


if __name__ == "__main__":
    BMW = Car("BMW", "m3", "diesel", 20)
    BMW.color = "white"
    print(repr(BMW))
