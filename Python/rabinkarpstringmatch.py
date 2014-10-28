#Implements Rabin and Karp algorithm for efficient string matching

def printOutput(output, length):
	for i in range(0, length):
		if output[i] == 1: 
			print('^', end="")
		else: 
			print(' ', end="")

def getHash(needle):
	val = 0
	c_val = 0
	for i in range(0, len(needle)):
		c_val = needle[i]
		val += ord(c_val)
	return val

def getOutput(needle, haystack):
	needleLength = len(needle)
	haystackLength = len(haystack)

	positions = [0]*haystackLength

	for i in range(0, haystackLength):
		positions[i] = 0

	hashNeedle = getHash(needle)
	hashHaystack = getHash(haystack[0:needleLength])

	if (hashHaystack == hashNeedle):
		if (haystack[:needleLength] == (needle)):
			positions[0] = 1

	for i in range (0, (haystackLength - needleLength)+1):
		c_val = haystack[i-1]
		val = ord(c_val);
		hashHaystack -= val
		c_val = haystack[needleLength+i-1]
		val = ord(c_val);
		hashHaystack += val
		if (hashHaystack == hashNeedle):
			if (haystack[i:needleLength+i] == (needle)):
				positions[i] = 1
	
	return positions

needle = input()
haystack = input()

length = len(haystack)

output = getOutput(needle, haystack)
print(haystack)
printOutput(output, length)