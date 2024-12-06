# Task Management Service

This project is a system for managing tasks. With this application, you can create, search, and modify tasks, as well as manage their statuses.

## Features

### 1. **Create New Tasks**
- You can create tasks via the API. Each task will be saved in the database and have a unique identifier.
- To create a task, send a request with the `description` and `taskStatus` fields.

### 2. **View All Tasks**
- You can retrieve a list of all tasks available in the system.

### 3. **Search Tasks by Status**
- The system allows you to filter tasks by status (e.g., "NEW", "IN_PROGRESS", "COMPLETED"). This helps quickly find the tasks you need.
- Example: `api/tasks/in%20progress`

### 4. **Manage a Specific Task**
- You can retrieve a task by ID, delete it, or update the task's information.

## API for Task Management

### **Get All Tasks**

- **GET** `/api/tasks`

  **Response:**
  ```json
  [
    {
      "id": 1,
      "description": "Description of task",
      "status": "In procces"
    },
    {
      "id": 2,
      "title": "Task 2",
      "description": "Description of task 2",
      "status": "Completed"
    }
  ] 

Get Tasks by Status
GET /api/tasks/{status}
Example: /api/tasks/in%20progress
Response:
    [
     {
       "id": 1,
       "description": "Description of task", 
       "status": "In progress"
     }
    ]

Create a New Task
POST /api/tasks
Request Body:
  {
    "description": "Description of task",
    "taskStatus": "NEW"
  }
Response:
    {
     "id": 1,
     "description": "Description of task",
     "taskStatus": "NEW"
    }


Specific Task
    GET Task
        /api/tasks/{taskId}
        Example: /api/tasks/1
        Response:
            {
             "id": 1,
             "description": "Description of task",
             "taskStatus": "NEW"
            }
    Delete a Task
        DELETE /api/tasks/{taskId}
        Example: /api/tasks/1

    
    Update a Task
        PUT /api/tasks/{taskId}
        Example: /api/tasks/1
        Request Body:
            {
             "description": "Updated description of task",
             "taskStatus": "IN_PROGRESS"
            }
        Response:
            {
             "id": 1,
             "description": "Updated description of task",
             "taskStatus": "IN_PROGRESS"
            }
        

