#Harmonics
import sys

number = int(sys.argv[1])
sum = 0.0

for i in range(1, number+1):
	sum += 1.0 / i
print(sum)
