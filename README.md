# Welcome to My API Created as tool for my Frontend Challenge

## Index

    - API documentation

# API documentation

## URL

```
	https://apifigure.herokuapp.com/
```

## Authentication

### POST /auth

return basic data user and token type JWT

#### Resource Information

| Question         | Answer |
| ---------------- | ------ |
| Response formats | Json   |

### Example Request

```
  {
  	"username": "superadmin",
    "password": "bingola22"
  }
```

### Example Response

```
    {
    	"Token": "eyJhbGciOiJIUzUxMiJ9.eyJhdXRob3JpdGllcyI6Ilt7XCJhdXRob3JpdHlcIjpcIlJPTEVfQURNSU5cIn1dIiwic3ViIjoic3VwZXJhZG1pbiIsImV4cCI6MTYyMTI1NTE3OH0.kIXQwq5zXCYAUYtuDtKjR4YEnQyK1uduK-thdnVfGKBoVsK_n-CNZmHzooF57-aj5JDgTKWyVHShzD7DdK5izQ"
    }
```

# API reference contents

     GET  /figure
     POST /figure
     GET /figure/group/{id}
     GET  /groupfigure
     DELETE /figure/{id}

# GET /figure

Returns the Figures

### Resource Information

| Question                 | Answer |
| ------------------------ | ------ |
| Response formats         | Json   |
| Requires authentication? | Yes    |

### Example Response

```
 {
    "data": [
        {
            "id": 14,
            "figureName": "Letra A",
            "idFigureGroup": 1,
            "positions": [0,0,1,0,0,0,1,0,1,0,1,0,0,0,1,1,1,1,1,1,1,0,0,0,1]
        },
        {
            "id": 16,
            "figureName": "Lineal 2",
            "idFigureGroup": 6,
            "positions": [0,0,1,0,0,0,1,0,1,0,1,0,0,0,1,1,1,1,1,1,1,0,0,0,1]
        },
    ],
    "message": "Lista generada con exito",
    "errors": null
}
```

### Parameters

not have

# POST /figure

Creates a new Figure

### Resource Information

| Question                 | Answer |
| ------------------------ | ------ |
| Response formats         | Json   |
| Requires authentication? | Yes    |

### Parameters

not have

### Example Request

```
{

  "figureName": "Letra A",
  "idFigureGroup": 1,
  "positions": [0,0,1,0,0,0,1,0,1,0,1,0,0,0,1,1,1,1,1,1,1,0,0,0,1]
}
```

### Example Response

```mvn
{
    "data": 25,
    "message": "Figura creado con exito",
    "errors": null
}
```

# GET /figure/group/{id}

Returns the Figures by id.

### Resource Information

| Question                 | Answer |
| ------------------------ | ------ |
| Response formats         | Json   |
| Requires authentication? | Yes    |

### Example Response

```
 {
    "data": [
        {
            "id": 14,
            "figureName": "Letra A",
            "idFigureGroup": 1,
            "positions": [0,0,1,0,0,0,1,0,1,0,1,0,0,0,1,1,1,1,1,1,1,0,0,0,1]
        },
        {
            "id": 16,
            "figureName": "Letra A",
            "idFigureGroup": 1,
            "positions": [0,0,1,0,0,0,1,0,1,0,1,0,0,0,1,1,1,1,1,1,1,0,0,0,1]
        },
    ],
    "message": "Lista generada con exito",
    "errors": null
}
```

### Parameters

not have

# GET /groupfigure

Returns the FiguresGroups

### Resource Information

| Question                 | Answer |
| ------------------------ | ------ |
| Response formats         | Json   |
| Requires authentication? | Yes    |

### Parameters

not have

### Example Response

```
  {
    {
    "data": [
        {
            "id": 1,
            "name": "Letra A",
            "oportunity": 14,
            "closegame_at": 1
        },
        {
            "id": 2,
            "name": "Letra L",
            "oportunity": 20,
            "closegame_at": 1
        },
        {
            "id": 3,
            "name": "Letra M",
            "oportunity": 40,
            "closegame_at": 1
        },
        {
            "id": 4,
            "name": "Vertical",
            "oportunity": 27,
            "closegame_at": 1
        },
        {
            "id": 5,
            "name": "Horizontal",
            "oportunity": 27,
            "closegame_at": 1
        },
        {
            "id": 6,
            "name": "LINEAL",
            "oportunity": 2,
            "closegame_at": 1
        },
        {
            "id": 7,
            "name": "MEDIO LLENO",
            "oportunity": 30,
            "closegame_at": 1
        },
        {
            "id": 8,
            "name": "LLENO SEGUNDA",
            "oportunity": 60,
            "closegame_at": 1
        }
    ],
    "message": "Lista generada con exito",
    "errors": null
    }
  }
```

# DELETE /figure/{id}

delete one existing Figure

### Resource Information

| Question                 | Answer |
| ------------------------ | ------ |
| Response formats         | Json   |
| Requires authentication? | Yes    |

### Path

| Name | Required | Description        |
| ---- | -------- | ------------------ |
| id   | Required | The ID of the bill |

### Example Response

```
  {

  }
```
