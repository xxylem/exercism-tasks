type nucleotide = A | C | G | T

let rec helper leftDNA rightDNA count = match leftDNA, rightDNA with
  | [],        []        -> (Ok count)
  | (n1::ns1), (n2::ns2) -> helper ns1 ns2 (count + (if n1 = n2 then 0 else 1))
  | _,         _         -> (Error "left and right strands must be of equal length")
  

let hamming_distance leftDNA rightDNA = match leftDNA, rightDNA with
  | [],   [_] -> (Error "left strand must not be empty")
  | [_],  []  -> (Error "right strand must not be empty")
  | _,    _   -> helper leftDNA rightDNA 0
