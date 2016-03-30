(defun simplify (expression)
  (cond 
    ((null expression) expression)
    ((eq (car expression) '+)
      (cond
        ((not (null (member '0 expression))) (cons (car expression) (simplify (cdr (remove '0 expression)))))
        (t (cons (car expression) (simplify (cdr expression))))))
    ((eq (car expression) '*)
      (cond
        ((not (null (member '0 expression))) 0)
        ((not (null (member '1 expression))) (cons (car expression) (simplify (cdr (remove '1 expression)))))
        (t (cons (car expression) (simplify (cdr expression))))))
    ((numberp (car expression)) (cons (car expression) (simplify (cdr expression))))
    ((listp (car expression)) (cons (simplify (car expression)) (simplify (cdr expression))))
    ((or (not (eq (car expression) '*)) (not (eq (car expression) '+)) (not (listp (car expression)))) (format t "Please enter a valid expression") NIL)
    (t (simplify (cdr expression)))
  )
)
