section .data
	buffer	dw	0h

section .text
	global 		_start
	
_start:
	mov		ecx, buffer
	mov		edx, 02h
	call		read
	mov		cx, word [buffer]
	cmp		cx, 0a31h
	je		one_dig
	call		exit

one_dig:
	mov		ecx, buffer
	mov		edx, 02h
	call		write
	call		exit
	
exit:
	mov		eax, 01h		; exit()
	xor		ebx, ebx		; errno
	int		80h
read:
	mov		eax, 03h		; read()
	mov		ebx, 00h		; stdin
	int		80h
	ret
write:
	mov		eax, 04h		; write()
	mov		ebx, 01h		; stdout
	int		80h
	ret