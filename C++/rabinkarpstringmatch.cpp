#include <iostream>
using namespace std;

//Implements Rabin and Karp algorithm for efficient string matching

int* getOutput(string needle, string haystack);

void printOutput(int* output, int length)
{
	for (int i = 0; i < length; i++)
	{
		if (output[i] == 1) cout << "^";
		else cout << " ";
	}
}

int main()
{
  string needle;
  string haystack;

  getline(cin, needle);
  getline(cin, haystack);

  int length = haystack.length();
  int* output = getOutput(needle, haystack);

  cout << haystack << endl;
  printOutput(output, length);
  return 0;
}

int getHash(string needle)
{
	int val = 0;
	char c_val = 0;
	for (int i = 0; (unsigned)i < needle.length(); i++)
	{
		c_val = needle[i];
		val += c_val;
	}
	return val;
}

int* getOutput(string needle, string haystack)
{
	string output = "";
	int needleLength = needle.length();
	int haystackLength = haystack.length();

	int* positions = new int [haystackLength];

	for (int i = 0; i < haystackLength; i++)
	{
		positions[i] = 0;
	}

	int hashNeedle = getHash(needle);
	int hashHaystack = getHash(haystack.substr(0, needleLength));

	if (hashHaystack == hashNeedle)
	{
		if (haystack.substr(0, needleLength) == (needle))
		{
			positions[0] = 1;
		}
	}

	for (int i = 1; i <= (haystackLength - (needleLength)); i++)
	{
		hashHaystack -= (int)haystack[i-1];
		hashHaystack += (int)haystack[needleLength+i-1];
		if (hashHaystack == hashNeedle)
		{	
			if (haystack.substr(i, needleLength) == (needle))
			{
				positions[i] = 1;
			}
		}
	}
	
	return positions;
}