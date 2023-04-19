use std::fs::File;
use std::io::{BufRead, BufReader};

fn main() {
    let file = File::open("../input.txt").unwrap_or_else(|_| panic!("Could not read file"));
    let reader = BufReader::new(file);

    let mut max = 0;
    let mut sum = 0;
    for line in reader.lines() {
        let line = line.unwrap_or_else(|_| panic!("Could not parse line"));
        match line.parse::<i32>() {
            Ok(num) => sum += num,
            Err(_) if line.is_empty() => {
                max = max.max(sum);
                sum = 0;
            }
            _ => panic!("Could not parse line"),
        }
    }
    println!("{}", max)
}
