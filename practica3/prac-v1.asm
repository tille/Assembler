section .data
	line: 		equ 38
	size: 		equ 10
	p:		db ' ',`\u2590`,'3 ','222',10
	pLen:		equ $-p
	rows: 		equ 114
	cols:		equ 12
	pos: 		equ 549
	buffer: 	dw 0h
	game:	dw	'_____________________________________',10

		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,10
	
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,10
	
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,10
	
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,10
	
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u2588`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,10
	
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,10

		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,10
	
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,10
	
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,`\u0020`,`\u0000`,`\u0020`,`\u0020`
		dw    	`\u2590`,10
	
		dw    	`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`
		dw    	`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`
		dw    	`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`
		dw    	`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`,`\u203e`
		dw    	`\u203e`,10
	
	gameLen:	equ $-game
	der:	dd  	172186395
	izq:	dd	172251931
	sub:	dd	172055323
	baj:	dd	172120859
	indD:	dd	5
	indI:	dd	5
	;; esp, eip

section .text
	global 		_start
	
_start:
	call 		drawTable
	
	mov		ecx,buffer
	mov		edx,4
	call		read
	mov		cx,word [buffer]
	mov		eax,[der]
	cmp		[buffer],eax
	je		right
	cmp		cx,0a64h
	je 		right

	mov		eax,[izq]
	cmp		[buffer],eax
	je		left
	cmp		cx,0a61h
	je		left

	mov		eax,[sub]
	cmp		[buffer],eax
	je		up
	cmp		cx,0a77h
	je		up

	mov		eax,[baj]
	cmp		[buffer],eax
	je		down
	cmp		cx,0a73h
	je		down
	
	jne		bad
	
	call 		exit
	

one_dig:
	mov		ecx, buffer
	mov		edx, 02h
	call		write
	jmp		exit
	
bad:
	call		clear_scr
	jmp 		_start
	
exit:
	mov 		eax,1
	mov 		ebx,0
	int 		80h

read:
	mov 		eax,3
	mov 		ebx,0
	int 		80h
	ret

write:
	mov 		eax,4
	mov 		ebx,1
	int 		80h
	ret
	
right:
	call		clear_scr
	mov		eax,9
	cmp		[indD],eax
	jnge		right2
	jmp		_start

right2:
	mov		eax,[indD]
	inc		eax
	mov		[indD],eax
	mov 		ebp,[game+pos]
	mov 		[game+edi+cols],ebp
	add		edi,cols
	jmp 		_start

left:
	call		clear_scr
	mov		eax,1
	cmp		[indD],eax
	jnle		left2
	jmp 		_start
	
left2:
	mov		eax,[indD]
	dec		eax
	mov		[indD],eax
	mov 		ebp,[game+pos] 	; borrar antes
	mov 		[game+edi-cols],ebp
	sub		edi,cols
	jmp 		_start
	
up:
	call		clear_scr
	mov		eax,1
	cmp		[indI],eax
	jnle		up2
	jmp		_start

up2:
	mov		eax,[indI]
	dec		eax
	mov		[indI],eax
	mov 		ebp,[game+pos]
	mov 		[game+edi-rows],ebp
	sub		edi,rows
	jmp 		_start
	
down:
	call		clear_scr
	mov 		eax,9
	cmp		[indI],eax
	jnge		down2
	jmp 		_start

down2:
	mov		eax,[indI]
	inc		eax
	mov		[indI],eax
	mov 		ebp,[game+pos]
	mov 		[game+edi+rows],ebp
	add		edi,rows
	jmp 		_start
	
drawTable:
	cmp		edi,0
	je 		boolPos
	
	mov 		ecx,game
	mov 		edx,gameLen
	call 		write
	ret

boolPos:
	mov		edi,pos
	mov 		ecx,game
	mov 		edx,gameLen
	call 		write
	ret

input:
	mov 		ecx,buffer
	mov 		edx,02h
	call 		read
	ret

clear:	db  		27,91,50,74,27,91,49,59,49,72

clear_scr:	
	mov 		eax,4
	mov		ebx,1
	mov		ecx,clear
	mov 		edx,size
	int 		80h
	ret

