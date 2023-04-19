use std::fs;

fn main() {
    let contents = fs::read_to_string("../input.txt")
        .expect("Should have been able to read the file");

    let split: Vec<&str> = contents.split("\r\n").collect();

    let mut max = 0;
    let mut sum = 0;
    for line in split {
        if line == "" {
            max = std::cmp::max(max, sum);
            sum = 0
        } else {
            sum += line.parse::<i32>().unwrap()
        }
    }
    println!("{max}")
}
