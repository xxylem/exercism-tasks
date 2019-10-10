#lang racket

(provide hello)

;; [String] -> String
;; Given a name, returns "Hello, name!".
(define (hello [name "World"])
  (string-append "Hello, " name "!"))