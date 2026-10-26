from random import *

class LeftLessThanRight(Exception):
    pass

class NotInScope(Exception):
    pass

class NotOrYes(Exception):
    pass

def guessing():
    try:
        left = int(input("Enter the left boundary: "))
        right = int(input("Enter the right boundary: "))
        if left > right:
            raise LeftLessThanRight
        else:
            number = randint(left, right)
            attempt = 0
            while True:
                guess = int(input("Enter your guess: "))
                attempt += 1
                if guess < left or guess > right:
                    raise NotInScope
                elif guess < number:
                    print("Your guess is too low.")
                elif guess > number:
                    print("Your guess is too high.")
                else:
                    print(f"Correct! The number is {number}. It took you {attempt} attempts.")
                    play_again = input("Do you want to play again? (yes/not) ")
                    if play_again.lower() == 'yes':
                        guessing()
                    elif play_again.lower() == "not":
                        print("Thanks for the game.")
                        break
                    else:
                        raise NotOrYes
    except NotOrYes:
        print('You wrote neither "yes" nor "not"')
    except ValueError:
        print("Invalid input.")
    except NotInScope:
        print(f"Number should be between {left} and {right}. Invalid input.")
    except LeftLessThanRight:
        print("Invalid input.")
    except TypeError:
        print("Invalid input.")
guessing()
