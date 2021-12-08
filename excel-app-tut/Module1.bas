Attribute VB_Name = "Module1"
Sub deleteEmptyRows()
'' Delete any empty rows in the active worksheet

Dim i As Integer
Dim intLastRow As Integer

intLastRow = ActiveSheet.Cells.SpecialCells(xlLastCell).Row

For i = intLastRow To 1 Step -1
    If Application.CountA(Rows(i)) = 0 Then
        Rows(i).Delete
    End If
Next

End Sub

Sub addThreeSheets()
'' Add three sheets to the active workbook
Dim i As Integer
Dim sheet As Worksheet

For i = 1 To 3
    Set sheet = ActiveWorkbook.Sheets.Add(After:=ActiveWorkbook.Worksheets(ActiveWorkbook.Worksheets.Count))
Next i

End Sub
