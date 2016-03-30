(defun add-numbers(lis)
   (cond
    ((null lis) 0)
    ((listp (car lis))   (+ (add-numbers(car lis))(add-numbers(cdr lis))))
    ((numberp (car lis)) (+ (car lis)(add-numbers (cdr lis))))
    (t (add-numbers(cdr lis)))
 )
)
