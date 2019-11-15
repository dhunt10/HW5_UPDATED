# HW5_UPDATED
### By Darin and Satwik

##### Status

- [x] Model
- [ ] Model Test
- [x] Text View
- [ ] Text View Test
- [x] Graphical View
- [ ] Graphical View Test
- [ ] Controller
- [ ] Controller Test
- [ ] Additional View 
- [ ] Additional View Test
------------------------------------------------------------------

##### 3 inputs are possible for cells
**Values** 
 - Values can be:
  ````
  numbers 
  booleans
  strings
  ````
**Formulas** 
 - Formulas can include:
  ````
  SUM
  PROD
  COMB
  <
  ````
**Reference**
 - A reference to an additional cell or block of cells
 > - A1:B7 (Block Reference)
 > - C2 (Single Reference)

------------------------------------------------------------------
##### The following is an example input file 
````
A1 3
A2 7
A3 =(SUM 10 2)
A4 =(SUM A1 A2)
A5 =(PROD (SUM 10 20) (PROD 10 A4))
A6 =(SUM A2:B2)
A7 =(< A7 3)
````
