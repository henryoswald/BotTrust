from collections import deque

class Robot:
    directions = deque ([])
    location = 1
    destination = 1
    name = ""

    def action(self):
        if self.canPushButton():
            self.directions.popleft()
            self.findNextDestination()
        else:
            self.move()

    def canPushButton(self):
        if self.directions and self.directions[0][0]==self.name and self.location == self.destination:
            return True
        else:
            return False
        
    def findNextDestination(self):
        for co in self.directions:
            if co[0] == self.name:
                self.destination = co[1]
                return
            
    def move(self):
        if self.location<self.destination:
            self.location += 1
        elif self.location>self.destination:
            self.location -= 1
                

class World:
    time = 0
    robots = []
    
    directions= deque ([["o",2],["b",1],["b",2],["o",4]])
#    directions= deque ([["o",5],["o",8],["b",100]])
#    directions= deque ([["b",2],["b",1]])

    def __init__(self):
        names =[]
        for dir in self.directions:
            names.append(dir[0])

        names  = set(names)

        for name in names:
            robot = Robot()
            robot.name = name
            robot.directions = self.directions
            robot.findNextDestination()
            self.robots.append(robot)

    
    def run(self):
        while self.directions:
            self.time+=1

            for r in self.robots:
                r.action()
              
w = World()
w.run()
print 'Time:',w.time