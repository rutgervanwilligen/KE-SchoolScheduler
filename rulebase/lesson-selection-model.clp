;;; Classes ;;;
(defclass Lesson sss.scheduler.objects.Lesson)

(reset)


;;; Rules ;;;
(defrule wrong-rule
  ( Lesson (ranking ?ranking) )
  =>
  (bind ?ranking 1))