We need to design and implement a backend (REST API) for a service similar to pastebin.com - the service allows you to upload pieces of text (paste) and get a short link to them, which can be sent to other people.
When uploading a paste the user specifies:
1.Term during which the paste will be available through the link (expiration time) 10 minutes, 1 hour, 3 hours, 1 day, 1 week, 1 month after the expiration time to get access to the paste can not, including the author.
2.Restriction of access:
  public - available to everyone.
  unlisted - available only by link.
For the uploaded paste a short link like: my-awesome-pastebin.tld/abc123 is given.
Users can get information about the last downloaded public pastes by specifying its number.

Usage options
1. Pasta loading
   Description:
    The user wants to upload a text paste to the service with an expiration date and access type.
    The user navigates to the paste upload page.
    Enters the text paste in the content field.
    Selects the validity period of the paste (for example, 1 hour).
    Selects the type of access:Public - the paste is available for all, Unlisted - the paste is available only by link.
    User transmits data
    The system generates a short link to the paste, for example my-awesome-pastebin.tld/abc123, and displays it to the user.
    The paste is stored in the database with the selected parameters.
Alternate flow:
    If the user has not selected an expiration date or access type, the system displays an error and prompts the user to select these parameters.
2. Paste Viewer
   Description:
    A user wants to browse a paste by a short link.
    The user receives or knows the short link of the paste, for example my-awesome-pastebin.tld/abc123.
    The user follows the link in a browser.
    The system checks to see if the paste exists and has not expired.
    If the paste exists and is available, the system displays its contents.
    If the paste is unavailable (expired or deleted), the system displays a message that the paste is no longer available.
   Alternate Flow:
    If the link is incorrect or the paste does not exist, the system returns a 404 (Not Found) error.
3. Retrieving a list of recent public pastes
   Description:
    A user wants to retrieve a list of recent public pastes, for example, to view new pastes.
    The user sends a request to the server with a count parameter, e.g., GET /pastes/public?count=5.
    The system retrieves the 5 most recent public pastes from the database.
    The system returns the list of pastes as JSON.
   Alternate flow:
    If the number of pastes requested is greater than what is in the database or not specified, the system returns all available pastes.
6. Short link generation
   Description:
    Once a paste is uploaded, a short link is provided to the user to access the paste.
    When a paste is loaded into the system, it is stored with a unique identifier.
    The system generates a short link (e.g., my-awesome-pastebin.tld/abc123) that references this paste.
    The short link is displayed to the user after the paste is downloaded.
   Alternate flow:
    If generating the short link fails (for example, due to a system error), the system displays an error.