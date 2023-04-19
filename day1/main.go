package main

import (
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	file, err := os.ReadFile("day1/input.txt")
	if err != nil {
		panic(err)
	}

	content := string(file)
	split := strings.Split(content, "\r\n")

	max := 0
	sum := 0
	for _, s := range split {
		if "" == s {
			var tmp int
			if max > sum {
				tmp = max
			} else {
				tmp = sum
			}
			max = tmp
			sum = 0
		} else {
			atom, err := strconv.Atoi(s)
			if err != nil {
				panic(err)
			}
			sum += atom
		}
	}

	fmt.Printf(strconv.Itoa(max))
}
