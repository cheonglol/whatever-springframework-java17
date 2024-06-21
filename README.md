# whatever-springframework-java17

in this repo,

1. i experiment with designing a 'system' (if u could call it one)
2. i experiment with ideas
3. i experiment with DSA (born to use forloops, forced to learn how it works internally)

to run this,

1. get java17
2. use that maven cmd
3. figure the rest out 👍🏻

# Branches

1. using `main` branch to,
   - update `README.md` to journal or whatever I'm going to commit at this point of time

# Journal (See timestamps through commits)

- 6/21/2024
  - just stick with `@GeneratedValue(strategy=GenerationType.TABLE)` . i still don't know why the other options causes the embedded h2 to just fail on the second run (the first one just creates the table)
- 6/15/2024
  - note to self - "use dbeaver not h2 console"
  - run both applications at once using "dualStart.cmd"
- creating an example of image service for the interns I have to take care of.
  - store images in DB as VARBINARY, or BLOB, or ByteArr
  - create endpoint to OutputStream the image.
  - add multithreading/queue/schedule or something. (i've no idea, this is my first time doing this too, my juniors are lucky.)
