const fs = require('fs')

fs.readFile(__dirname + '/../input.txt', 'utf-8', (err, data) => {
    if (err) {
        console.error(err);
        return
    }

    let strings = data.split("\r\n");
    let max = 0;
    let sum = 0;
    for (let line of strings) {
        if ("" !== line) {
            max = Math.max(max, Number.parseInt(line))
            sum = 0
        } else {
            sum += Number.parseInt(line)
        }
    }
    console.log(max)
})